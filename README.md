# 📈 Monitor de Crypto Moedas - Bitcoin

Aplicativo Android simples que consulta a cotação do Bitcoin em tempo real.

## ✨ Funcionalidades

- Atualiza a cotação do Bitcoin ao clicar no botão.
- Exibe a data e hora da última atualização.
- Usa a API pública do [Mercado Bitcoin](https://www.mercadobitcoin.net/api/BTC/ticker/).

## 🛠️ Tecnologias Utilizadas

- Android Studio (Kotlin)
- Retrofit (para requisições HTTP)
- Gson (para parsear o JSON da API)

## 📷 Demonstração

### Tela inicial:
![image](https://github.com/user-attachments/assets/f601ca48-a8e2-4615-97f0-d5034f4a1dbc)

### Tela com cotação atualizada:
![image](https://github.com/user-attachments/assets/69f77bd0-57cb-4814-84dd-c730701f9f79)

## 🧩 Estrutura de Código

### Retrofit Service

```kotlin
interface MercadoBitcoinService {
    @GET("api/BTC/ticker/")
    suspend fun getTicker(): Response<TickerResponse>
}
```
## Modelo de Dados

```kotlin
class TickerResponse(
    val ticker: Ticker
)

class Ticker(
    val high: String,
    val low: String,
    val vol: String,
    val last: String,
    val buy: String,
    val sell: String,
    val date: Long
)
```

Inicialização do Retrofit

```kotlin
class MercadoBitcoinServiceFactory {
    fun create(): MercadoBitcoinService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.mercadobitcoin.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(MercadoBitcoinService::class.java)
    }
}
```

📋 Layout (XML)
```xml
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <TextView
        android:id="@+id/lbl_rate"
        android:text="Cotação - BITCOIN"
        android:textSize="20sp" />

    <TextView
        android:id="@+id/lbl_value"
        android:text="R$ 0,00"
        android:textSize="32sp"
        android:textStyle="bold" />

    <TextView
        android:id="@+id/lbl_date"
        android:text="dd/mm/yyyy hh:mm:ss" />

    <include
        layout="@layout/component_button_refresh" />
</LinearLayout>
```

🚀 Como Rodar o Projeto
1. Clone o repositório
2. Abra no Android Studio.
3. Rode o app em um emulador ou dispositivo real.

