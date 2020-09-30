package com.example.algorithm.test1.link;

/**
 * @author: heshineng
 * @createdBy: 2020/5/20 14:22
 */
public class Test {

    public static void main(String[] args) {
        Test test=new Test();
        long appNonAtsImpression = 22;
        long appNonAtsView = 40;
        long appNonAtsApply = 2;
        System.out.println(test.test1(appNonAtsImpression,appNonAtsView,appNonAtsApply));
        System.out.println(test.test2(appNonAtsImpression,appNonAtsView,appNonAtsApply));
        System.out.println(appNonAtsView / (double) appNonAtsImpression);
        System.out.println(appNonAtsApply / (double) appNonAtsView);
    }

    public int test1(long appNonAtsImpression, long appNonAtsView, long appNonAtsApply) {
        if (appNonAtsImpression == 0 || appNonAtsView == 0) {
            return 1;
        } else if (appNonAtsImpression > 50 && appNonAtsView / (double) appNonAtsImpression <= 0.05) {
            return 0;
        } else if (appNonAtsImpression > 20 && appNonAtsApply / (double) appNonAtsView <= 0.05) {
            return 0;
        } else {
            return 1;
        }
    }

    public int test2(long appNonAtsImpression, long appNonAtsView, long appNonAtsApply) {
        if (appNonAtsImpression == 0 || appNonAtsView == 0) {
            return 1;
        }
        if ((appNonAtsImpression > 50 && appNonAtsView / (double) appNonAtsImpression <= 0.05)
                || (appNonAtsImpression > 20 && appNonAtsApply / (double) appNonAtsView <= 0.05)) {
            return 0;
        }
        return 1;
    }
}
