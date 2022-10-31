import sttp.client3._

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

    def helloWorld(str:String): Unit = {
        val dummyEndpoint = uri"https://fantasy.espn.com/apis/v3/games/fba/seasons/2023/segments/0/leagues/1823804002"

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

            println("---\n")

            //

            // val request2: Request[String, Any] = basicRequest
            // .header("X-Correlation-ID", UUID.randomUUID().toString)
            // .response(asStringAlways)
            // .body("Hello, world!")
            // .post(uri"https://httpbin.org/post")
            // val response2: Response[String] = client.send(request2)

            // println(s"Response to POST:\n${response2.body}")

        } finally client.close()


    }


}