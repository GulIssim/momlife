package kz.vienna.momlife.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class Helper {

    public static List getStatuses(){
        List<PregnancyStatus> list = Arrays.asList(PregnancyStatus.values());
        System.out.println(list);
        return list;
    }

    public static List getPregnanciesStatuses(List pregnancies){
        List<String> statuses = new ArrayList();
        for (Iterator<String> i = pregnancies.iterator(); i.hasNext();) {
            String status = i.next();
            statuses.add(status);
        }
        return statuses;
    }
}
