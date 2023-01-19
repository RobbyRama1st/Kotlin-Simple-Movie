<h1 align="center">Simple Movie App</h1>

<p align="center">
<img src="https://user-images.githubusercontent.com/82755985/213356557-b5c30c93-c805-4e89-9b8d-6abba952cf16.jpg" width="30%"></img>  
<img src="https://user-images.githubusercontent.com/82755985/213356688-b26ef1af-7dec-452e-beb9-c63fcc15b984.jpg" width="30%"></img>  
<img src="https://user-images.githubusercontent.com/82755985/213356801-4952c6c2-84ca-420c-b496-2fecb5ad9559.jpg" width="30%"></img>
</p>


# Simple Movie App

Aplikasi android native movie sederhana yang dibuat menggunakan [Kotlin](https://kotlinlang.org/) dan menggunakan API dari [TheMovieDB](https://www.themoviedb.org/)

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
