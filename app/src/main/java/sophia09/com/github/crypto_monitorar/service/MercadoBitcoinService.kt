package sophia09.com.github.crypto_monitorar.service
import sophia09.com.github.crypto_monitorar.TickerResponse
import retrofit2.Response
import retrofit2.http.GET

interface MercadoBitcoinService {
    @GET("api/BTC/ticker/")
    suspend fun getTicker(): Response<TickerResponse>
}