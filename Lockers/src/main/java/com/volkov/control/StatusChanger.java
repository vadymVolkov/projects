package com.volkov.control;

import com.volkov.model.Locker;
import com.volkov.repository.LockerStatus;

import java.sql.SQLException;
import java.util.List;

public class StatusChanger {

    public static String change(String currentStatus) {
        if (currentStatus.equals("recomend")) {
            return "engaged";
        } else {
            return "recomend";
        }
    }

    public static String setEmptyStatus() {
        return "empty";
    }

    public static String setEngagedStatus() {
        return "engaged";
    }

    public static void optimizeLockers() throws SQLException, ClassNotFoundException {
        List<Locker> lokers = LockerStatus.getLockersFromLockerStatus();
        int priority;
        int priorityNext = 0;
        int priorityPrev = 0;
        for (int i = 0; i < lokers.size(); i++) {
            priority = lokers.get(i).getPriority();
            if (i<lokers.size()-1) {
                priorityNext = lokers.get(i + 1).getPriority();
            }
            if (i>0) {
                priorityPrev = lokers.get(i - 1).getPriority();
            }
            if (i == 0 && priority==3 && priorityNext!=3) {
                LockerStatus.setPriorityById(i+1,2);
                LockerStatus.setStatusById(i+1,"notrecomend");
            }
            if (i>0 && i<lokers.size()-1 && priority==3 && priorityPrev!=3 && priorityNext!=3) {
                LockerStatus.setPriorityById(i+1,2);
                LockerStatus.setPriorityById(i-1,2);
                LockerStatus.setStatusById(i+1,"notrecomend");
                LockerStatus.setStatusById(i-1,"notrecomend");
            }
            if (i == lokers.size()-1 && priority==3 && priorityPrev!=3) {
                LockerStatus.setPriorityById(i-1,2);
                LockerStatus.setStatusById(i-1,"notrecomend");
            }
        }
    }
    public static void optimizeAfterDelete (int idDeletedElement) throws SQLException, ClassNotFoundException {
        List<Locker> lokers = LockerStatus.getLockersFromLockerStatus();
        int priorityNextNext=0;
        int priorityPrevPrev = 0;
        int priorityNext=0;
        int priorityPrev = 0;
        if (idDeletedElement<lokers.size()-1) {
            priorityNext=lokers.get(idDeletedElement+1).getPriority();
        }
        if (idDeletedElement>0) {
            priorityPrev=lokers.get(idDeletedElement-1).getPriority();
        }
        if (idDeletedElement<lokers.size()-2) {
            priorityNextNext=lokers.get(idDeletedElement+2).getPriority();
        }
        if (idDeletedElement>1) {
            priorityPrevPrev=lokers.get(idDeletedElement-2).getPriority();
        }
        if ((idDeletedElement==0 || idDeletedElement==1) && priorityNextNext!=3) {
            LockerStatus.setPriorityById(idDeletedElement+1,1);
            LockerStatus.setStatusById(idDeletedElement+1,"recomend");
        }
        if (idDeletedElement>1 && idDeletedElement<(lokers.size()-3) && priorityPrevPrev!=3) {
            LockerStatus.setPriorityById(idDeletedElement-1,1);
            LockerStatus.setStatusById(idDeletedElement-1,"recomend");
        }
        if (idDeletedElement>1 && idDeletedElement<(lokers.size()-3) && priorityNextNext!=3) {
            LockerStatus.setPriorityById(idDeletedElement+1,1);
            LockerStatus.setStatusById(idDeletedElement+1,"recomend");
        }
        if ((idDeletedElement==(lokers.size()-3) || idDeletedElement==(lokers.size()-2)) && priorityPrevPrev!=3 ) {
            LockerStatus.setPriorityById(idDeletedElement-1,1);
            LockerStatus.setStatusById(idDeletedElement-1,"recomend");
        }
        if (idDeletedElement==(lokers.size()-2) && priorityNext!=3 ) {
            LockerStatus.setPriorityById(idDeletedElement+1,1);
            LockerStatus.setStatusById(idDeletedElement+1,"recomend");
        }
        if (idDeletedElement==1 && priorityPrev!=3 ) {
            LockerStatus.setPriorityById(idDeletedElement-1,1);
            LockerStatus.setStatusById(idDeletedElement-1,"recomend");
        }
    }
}
