package com.example.aniverse.utils;

import com.example.aniverse.model.anime.AnimeTop;
import com.example.aniverse.model.manga.MangaTop;
import java.util.List;

public interface ItemClickListener {

    void onAnimeClicked(AnimeTop anime);

    void onMangaClicked(MangaTop anime);


}
