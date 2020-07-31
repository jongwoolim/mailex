package org.zerock.fortune;

import java.util.Arrays;
import java.util.Collections;

public class FortuneTeller {

    private String[] arr;

    public FortuneTeller(){
        arr = new String[]{"대길", "소길", "소흉", "대흉"};
    }

    public String getFortune(){
        Collections.shuffle(Arrays.asList(arr));
        return arr[0];
    }

}
