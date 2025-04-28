# 📈 Monitor de Crypto Moedas - Bitcoin

Aplicativo Android simples que consulta a cotação do Bitcoin em tempo real.

## ✨ Funcionalidades

- Atualiza a cotação do Bitcoin ao clicar no botão.
- Exibe a data e hora da última atualização.
- Usa a API pública do [Mercado Bitcoin](https://www.mercadobitcoin.net/api/BTC/ticker/).
- Exemplo de retorno da API:
```json
{
  "ticker": {
    "high": "540000.00",
    "low": "530000.00",
    "vol": "100.0",
    "last": "535500.00",
    "buy": "534000.00",
    "sell": "537000.00",
    "date": 1618844472
  }
}
```

## 🛠️ Tecnologias Utilizadas

- **Android Studio** (Kotlin)
- **Retrofit 2.9.0** (para requisições HTTP)
- **Gson Converter** (para conversão JSON)
- **Kotlin Coroutines** (para chamadas assíncronas)
- **AppCompat** e componentes da **AndroidX**
> **SDK mínimo:** 24 (Android 7.0 Nougat)  
> **SDK alvo:** 34 (Android 14)

## 🖥️ Imagens do App

### Tela inicial:
![image](https://github.com/user-attachments/assets/f601ca48-a8e2-4615-97f0-d5034f4a1dbc)

### Tela com cotação atualizada:
![image](https://github.com/user-attachments/assets/69f77bd0-57cb-4814-84dd-c730701f9f79)

## 🧩 Estrutura de Código

### Retrofit Service
Define a interface que faz a requisição HTTP para a API do Mercado Bitcoin.
A função getTicker() busca as informações da cotação do Bitcoin.
```kotlin
interface MercadoBitcoinService {
    @GET("api/BTC/ticker/")
    suspend fun getTicker(): Response<TickerResponse>
}
```
## Modelo de Dados
A API retorna um JSON com várias informações sobre o Bitcoin. As classes TickerResponse e Ticker mapeiam esse JSON para objetos Kotlin para facilitar o uso no código.

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

## Inicialização do Retrofit
A classe MercadoBitcoinServiceFactory cria o Retrofit configurado para a API do Mercado Bitcoin e retorna uma instância da interface que permite fazer a requisição.
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

## 📋 Layout (XML)
Define como os dados serão exibidos na tela: inclui o valor do Bitcoin, a data e um botão para atualizar as informações.
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <include
        android:id="@+id/component_toolbar"
        layout="@layout/component_toolbar_main"
        android:layout_width="match_parent"
        android:layout_height="75dp"
        android:layout_weight="0" />

    <include
        android:id="@+id/component_quote_information"
        layout="@layout/component_quote_information"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1" />

</LinearLayout>
```

## 🚀 Como Rodar o Projeto
1. Clone o repositório
2. Abra no Android Studio.
3. Rode o app em um emulador ou dispositivo real.

