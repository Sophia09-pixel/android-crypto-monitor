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
- **Jetpack Compose** (interface de usuário moderna)
- **AppCompat** e componentes da **AndroidX**
> **SDK mínimo:** 24 (Android 7.0 Nougat)  
> **SDK alvo:** 34 (Android 14)

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

## Inicialização do Retrofit

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
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_gravity="center"
    android:gravity="center"
    android:orientation="vertical">

    <TextView
        android:id="@+id/lbl_rate"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/label_rate"
        android:textSize="20sp" />

    <TextView
        android:id="@+id/lbl_value"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/label_value"
        android:textSize="32sp"
        android:textStyle="bold" />

    <TextView
        android:id="@+id/lbl_date"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/label_date" />

    <include
        layout="@layout/component_button_refresh"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

</LinearLayout>
```

## 🚀 Como Rodar o Projeto
1. Clone o repositório
2. Abra no Android Studio.
3. Rode o app em um emulador ou dispositivo real.

