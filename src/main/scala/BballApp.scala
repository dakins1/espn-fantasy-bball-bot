
import EspnAPI._

object BballApp extends App {
        
    EspnAPI.helloWorld()
    // TODO put this in separate Discord client
    val discordUrl = "https://discord.com/api/webhooks"
    val serverId = "1033141843153670205"
    val webhookToken = "9cZNz_qx1d5RYGuDWuX1w_WYLRfJMVXbzzzE3yZSRliJFIDqOXczaLFyS9wp_CV34mIV"
    val discordUri = s"$discordUrl/$serverId/$webhookToken"

    

    case class LeagueTeam(name: String, currentScore: Double)


}