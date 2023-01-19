# news-apps

Aplikasi android native movie sederhana yang dibuat menggunakan [Kotlin]([https://flutter.dev/](https://kotlinlang.org/)  dan menggunakan API dari [OpenWeatherMap]

# Tech stack & third party libraries
- SDK minimal level 24
- Berbasis [Kotlin](https://kotlinlang.org/), [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx .coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) + [State Flow](https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/-state -flow/) untuk asinkronus.
- [Koin](https://insert-koin.io/) sebagai dependency injection
- ViewModel
- ViewBinding
- Arsitektur
   - Arsitektur MVVM
   - Pola Repositori
- [Retrofit2](https://github.com/square/retrofit): Buat REST API.
- [OkHttp3](https://square.github.io/okhttp/): Menerapkan interseptor dan logging.
- [Moshi](https://github.com/square/moshi/): Library JSON modern untuk Kotlin dan Java.
- [Glide](https://github.com/bumptech/glide): Memuat gambar dari jaringan.
- [androidYoutubePlayer](https://github.com/PierfrancescoSoffritti/android-youtube-player): memutar video trailer youtube.

## Features
- Trending movie slider
- Latest movie
- Menampilkan trailer
