package com.project.xghk416.pojo;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PublicOfferingEntity {

    private Boolean hasHeightElite = false;
    private Boolean hasElite = false;
    private Boolean hasNew = false;

    private List<String> position;
    private List<String> profession;
    private List<String> tag;

   public String getAllTags(){
       List<String> allTags = new ArrayList<>();
       if (hasHeightElite){
           allTags.add("高级资深干员");
       }
       if (hasElite){
           allTags.add("资深干员");
       }
       if (hasNew){
           allTags.add("新手");
       }
       allTags.addAll(position);
       allTags.addAll(profession);
       allTags.addAll(tag);
       return allTags.toString();
   }

    public List<String> getAllTagsList() {
        List<String> allTagsList = new ArrayList<>();
        if (hasHeightElite){
            allTagsList.add("高级资深干员");
        }
        if (hasElite){
            allTagsList.add("资深干员");
        }
        if (hasNew){
            allTagsList.add("新手");
        }
        allTagsList.addAll(position);
        allTagsList.addAll(profession);
        allTagsList.addAll(tag);
        return allTagsList;
    }
}
