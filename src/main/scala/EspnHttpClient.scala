import sttp.client3.SimpleHttpClient
import sttp.client3.Response
import sttp.client3.basicRequest
import sttp.model.Uri
import sttp.model.Uri.UriContext

//FANTASY_BASE_ENDPOINT = 'https://fantasy.espn.com/apis/v3/games/'
// old seasons = FANTASY_BASE_ENDPOINT + "/leagueHistory/" + league_id + "?seasonId=" + year
// seasons = FANTASY_BASE_ENDPOINT + "/seasons/" + year + "/segments/0/leagues/" + league_id

// league_id = 1823804002
//season_id = 2023
// my team id = 3
// matchupPeriodId = 2

//FANTASY_SPORTS = {
//     'nfl' : 'ffl',
//     'nba' : 'fba'
// }

//https://fantasy.espn.com/apis/v3/games/fba/seasons/2023/segments/0/leagues/1823804002?view=mDraftDetail
// https://fantasy.espn.com/apis/v3/games/fba/seasons/2023/segments/0/leagues/1823804002

// for private leagues we need some equivalent too:

// r = requests.get(url,
                //  cookies={"swid": "{SWID-COOKIE-HERE}",
                //           "espn_s2": "LONG_ESPN_S2_COOKIE_HERE"})

object EspnAPI {
    private val espnUrl = "https://fantasy.espn.com"
    private val leagueEndpoint = "uri/apis/v3/games/fba/seasons/2023/segments/0/leagues"
    private val leagueId = 1823804002
    private val uri: Uri = uri"$espnUrl/$leagueEndpoint/$leagueId"
    private val swid = "{E4590F95-F8DF-44C9-A711-EBB63A6655C5}"
    private val espn_s2 = "AEAzuLYNJGOWFcoMX8Kmp4F8MJ7hiYmX8l6ZOHGvkZsYMQKoHNFcGi60bRihmm19tklGNRyw1YPLbvXnNAEITg7m4s8O9Xwm3fEA0cBLI%2FD%2FT2LIcSQcFfaEv%2B5fxCGUqsq7JhprG4HI9nap8oBoSW%2Fv7B3vPopPeUKuExUOoNFXU0nwzolJG8hGd2EOsiO8X%2BtaRn637FazXoj%2Bp9wD97IIP4c1OqaMpmHicz0SBF3uI7CV3FWQ7TMm%2B2LnrxO9k4%2F0kk5S20bpmSUHsV6bcvTW"


    def getLeagueTeams(): Seq[BballApp.LeagueTeam] = {
        val client = SimpleHttpClient()
        client.send(basicEspnRequest).body 
        client.close()
        ???
    }

    // made this mistake of hard coding this to the leagues endpoint, need to figure out teams endpoint + parameterize basic requests
    private val basicEspnRequest = 
        basicRequest
            .get(uri)
            .cookies("swid" -> swid, "espn_s2" -> espn_s2)

    def helloWorld(): Unit = {
        

        val client = SimpleHttpClient()

        //swid and espn_s2, these are stored under cookies is way to access private leagues. other way is to set league to public.

        try {
            val response: Response[Either[String, String]] = client.send(basicRequest
                                                                            .get(dummyEndpoint)
                                                                            .cookies("swid" -> "{E4590F95-F8DF-44C9-A711-EBB63A6655C5}",
                                                                                    "espn_s2" -> "AEAzuLYNJGOWFcoMX8Kmp4F8MJ7hiYmX8l6ZOHGvkZsYMQKoHNFcGi60bRihmm19tklGNRyw1YPLbvXnNAEITg7m4s8O9Xwm3fEA0cBLI%2FD%2FT2LIcSQcFfaEv%2B5fxCGUqsq7JhprG4HI9nap8oBoSW%2Fv7B3vPopPeUKuExUOoNFXU0nwzolJG8hGd2EOsiO8X%2BtaRn637FazXoj%2Bp9wD97IIP4c1OqaMpmHicz0SBF3uI7CV3FWQ7TMm%2B2LnrxO9k4%2F0kk5S20bpmSUHsV6bcvTW"))

            response.body match {
            case Left(body)  => println(s"Non-2xx response to GET with code ${response.code}:\n$body")
            case Right(body) => println(s"2xx response to GET:\n$body")
            }


        } finally client.close()


    }


}