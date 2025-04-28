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



