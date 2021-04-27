package com.example.aniverse.api;

import com.example.aniverse.model.anime.AnimeInfoCall;
import com.example.aniverse.model.anime.AnimeTopCall;
import com.example.aniverse.model.anime.SearchAnime;
import com.example.aniverse.model.manga.MangaInfoCall;
import com.example.aniverse.model.manga.MangaTopCall;
import com.example.aniverse.model.manga.SearchManga;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface AnimeMangaApi {

    @GET
    Call<AnimeTopCall> getTopAnimes(@Url String url);

    @GET
    Call<MangaTopCall> getTopMangas(@Url String url);

    @GET
    Call<AnimeInfoCall> getInfoAnime(@Url String url);

    @GET
    Call<MangaInfoCall> getInfoManga(@Url String url);

    @GET
    Call<SearchAnime> getAnimes(@Url String url);

    @GET
    Call<SearchManga> getMangas(@Url String url);

}
