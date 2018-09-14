package com.codzunk.recycode.data;

import android.content.Context;

import com.codzunk.recycode.R;
import com.codzunk.recycode.data.model.DataModel;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private int[] resDrawables = {
            R.drawable.amader_priyo_fol_main, R.drawable.ami_khoka_main,
            R.drawable.ata_gache_tota_pakhi_main, R.drawable.ayre_ay_tiye_main,
            R.drawable.bakbakum_payra_main, R.drawable.boro_hobe_main,
            R.drawable.dak_pari_main, R.drawable.hattima_tim_tim_main,
            R.drawable.khete_hoy_main, R.drawable.khoka_khuku_pathshalay_zay_main,
            R.drawable.khokar_rag_2_main, R.drawable.khokar_rag_main,
            R.drawable.khokon_khokon_main, R.drawable.khuka_khuku_main,
            R.drawable.mach_dhorte_main, R.drawable.mamar_bari_main,
            R.drawable.prarthona_main, R.drawable.rong_tuli_main,
            R.drawable.sonamonir_be_main, R.drawable.valo_chele_main
    };

    private int[] resThumb = {
            R.drawable.amader_priyo_fol_thumbnail, R.drawable.ami_khoka_thumbnail,
            R.drawable.ata_gache_tota_pakhi_thumbnail, R.drawable.ayre_ay_tiye_main_thumbnail,
            R.drawable.bakbakum_payra_thumbnail, R.drawable.boro_hobe_thumbnail,
            R.drawable.dak_pari_thumbnail, R.drawable.hattima_tim_tim_thumbnail,
            R.drawable.khete_hoy_thumbnail, R.drawable.khoka_khuku_pathshalay_zay_thumbnail,
            R.drawable.khokar_rag_2_thumbnail, R.drawable.khokar_rag_thumbnail,
            R.drawable.khokon_khokon_thumbnail, R.drawable.khuka_khuku_thumbnail,
            R.drawable.mach_dhorte_thumbnail, R.drawable.mamar_bari_thumbnail,
            R.drawable.prarthona_thumbnail, R.drawable.rong_tuli_thumbnail,
            R.drawable.sonamonir_be_thumbnail, R.drawable.valo_chele_thumbnail
    };

    private String[] resTitles;

    private List<DataModel> dataModels;

    public DataManager(Context context) {
        dataModels = new ArrayList<>();
        resTitles = context.getResources().getStringArray(R.array.chora_headline);
    }

    public void loadResources(){
        for (int i=0; i<resDrawables.length; i++) {
            DataModel model = new DataModel();
            model.setImgTitle(resTitles[i]);
            model.setImgResId(resDrawables[i]);
            model.setThumbNail(resThumb[i]);
            dataModels.add(model);
        }
    }

    public List<DataModel> getResources(){
        return dataModels;
    }
}
