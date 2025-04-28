# android-crypto-monitor
 📈 Monitor de Crypto Moedas - Bitcoin
Este é um aplicativo Android simples que exibe a cotação atual do Bitcoin ao clicar no botão "Atualizar".

✨ Funcionalidades
Recupera a cotação do Bitcoin em tempo real.

Mostra o valor e a data/hora da última atualização.

Interface clean e intuitiva.

🔗 API Utilizada
Mercado Bitcoin API - Ticker BTC
https://www.mercadobitcoin.net/api/BTC/ticker/

Exemplo de retorno da API:
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
🛠 Tecnologias
Kotlin para a programação Android.

Retrofit para requisições HTTP.

Gson para conversão JSON.

Android Studio como ambiente de desenvolvimento.

📄 Estrutura do Código
TickerResponse.kt e Ticker.kt → Representam os dados da resposta da API.

MercadoBitcoinService.kt → Interface Retrofit para fazer a chamada GET.

MercadoBitcoinServiceFactory.kt → Cria a instância Retrofit.

activity_main.xml → Layout da tela principal, com os TextViews para cotação e data, e botão de atualizar.

🖥️ Imagens do App
![image](https://github.com/user-attachments/assets/f601ca48-a8e2-4615-97f0-d5034f4a1dbc)
![image](https://github.com/user-attachments/assets/69f77bd0-57cb-4814-84dd-c730701f9f79)

🚀 Como Rodar
Clone o projeto:
git clone https://github.com/seu-usuario/monitor-bitcoin-android.git
Abra o projeto no Android Studio.
Conecte um emulador ou dispositivo Android.
Rode o app!


