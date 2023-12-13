package com.example.subnetcalculatorfx;

public class Calculation {
    static BinariesSNM binariesSNM;
    static BinariesIP binariesIP;
    private static MainController mainController;

    public Calculation(MainController mainController) {
        this.mainController = mainController;
        this.binariesSNM = new BinariesSNM(mainController);
        this.binariesIP = new BinariesIP(mainController);
    }

    public void calculations(String ipAddress) {
        binariesSNM.stringToIntSNM();
        binariesIP.stringToIntIp(ipAddress);

        // check wo bei beiden Zahlen gleichzeitig eine 1 stehet
        int netID1 = binariesIP.okt1Int & binariesSNM.snmokt1Int;
        System.out.println(binariesIP.okt1Int + (" ") + binariesSNM.snmokt1Int);
        System.out.println("bin netid 1: " + netID1);
        int netID2 = binariesIP.okt2Int & binariesSNM.snmokt2Int;
        System.out.println("bin netid 2: " + netID2);
        int netID3 = binariesIP.okt3Int & binariesSNM.snmokt3Int;
        System.out.println("bin netid 3: " + netID3);
        int netID4 = binariesIP.okt4Int & binariesSNM.snmokt4Int;
        System.out.println("bin netid 4: " + netID4);

        int invertedMask1 = ~binariesSNM.snmokt1Int & 0xff;
        int invertedMask2 = ~binariesSNM.snmokt2Int & 0xff;
        int invertedMask3 = ~binariesSNM.snmokt3Int & 0xff;
        int invertedMask4 = ~binariesSNM.snmokt4Int & 0xff;

        int broadcast1 = netID1 | invertedMask1;
        int broadcast2 = netID2 | invertedMask2;
        int broadcast3 = netID3 | invertedMask3;
        int broadcast4 = netID4 | invertedMask4;

        mainController.netIdLabel.setText(String.format("%d.%d.%d.%d", netID1, netID2, netID3, netID4));
        mainController.bcLabel.setText(String.format("%d.%d.%d.%d", broadcast1, broadcast2, broadcast3, broadcast4));
        mainController.rangeLabel.setText(String.format("%d.%d.%d.%d", netID1 + 1, netID2 + 1, netID3 + 1, netID4 + 1));
        mainController.rangeLabel1.setText(String.format("%d.%d.%d.%d", broadcast1 - 1, broadcast2 - 1, broadcast3 - 1, broadcast4 - 1));
        mainController.hostLabel.setText(String.valueOf((broadcast4 - 1) - (netID4 + 1)));
    }
}
