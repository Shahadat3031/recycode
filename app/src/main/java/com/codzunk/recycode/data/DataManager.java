package com.codzunk.recycode.data;

import com.codzunk.recycode.R;
import com.codzunk.recycode.data.model.DataModel;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private int[] resDrawables = {
            R.drawable.amader_priyo_fol_main, R.drawable.ami_khoka_main,
            R.drawable.ata_gache_tota_pakhi_main, R.drawable.ayre_ay_tiye_main,
            R.drawable.bakbakum_payra_main, R.drawable.boro_hobe_main,
            R.drawable.dak_pari_main, R.drawable.hattima_tim_tim_main
    };
    private List<DataModel> dataModels;

    public DataManager() {
        dataModels = new ArrayList<>();
    }

    public void loadResources(){
        for (int res:
             resDrawables) {
            DataModel model = new DataModel();
            model.setImgResId(res);
            dataModels.add(model);
        }
    }

    public List<DataModel> getResources(){
        return dataModels;
    }
}
