package kz.vienna.momlife.util;

import kz.vienna.momlife.model.entity.Pregnancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class Helper {

    public static List getStatuses(){
        List<PregnancyStatus> list = Arrays.asList(PregnancyStatus.values());
        return list;
    }

    public static List getPregnanciesStatuses(List pregnancies){
        List<String> statuses = new ArrayList();
        for (Iterator<Pregnancy> i = pregnancies.iterator(); i.hasNext();) {
            Pregnancy pregnancy = i.next();
            String status = pregnancy.getStatus();
            statuses.add(status);
        }
        return statuses;
    }
}
