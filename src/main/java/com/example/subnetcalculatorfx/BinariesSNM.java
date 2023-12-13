package com.example.subnetcalculatorfx;

public class BinariesSNM {
    String[] snmSplit;
    int snmokt1Int;
    int snmokt2Int;
    int snmokt3Int;
    int snmokt4Int;
    boolean validatedSnm = false;
    String binResult1Snm;
    String binResult2Snm;
    String binResult3Snm;
    String binResult4Snm;


    private MainController mainController;
    BinariesIP binariesIP;
    Calculation calculation;


    public BinariesSNM(MainController mainController) {
        this.mainController = mainController;

    }

    public void stringToIntSNM() {
        boolean validInput = false;
        while (!validInput) {
            snmSplit = mainController.selectedSubnetMask.split("\\.");

            try {
                String okt1 = snmSplit[0];
                String okt2 = snmSplit[1];
                String okt3 = snmSplit[2];
                String okt4 = snmSplit[3];

                snmokt1Int = Integer.parseInt(okt1);
                snmokt2Int = Integer.parseInt(okt2);
                snmokt3Int = Integer.parseInt(okt3);
                snmokt4Int = Integer.parseInt(okt4);

                validInput = true;
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                validatedSnm = false;
                break;
            }
        }

    }

    private String fillTo8Bits(int result) {
        String binaryString = Integer.toBinaryString(result);
        int length = binaryString.length();

        while (length < 8) {
            binaryString = "0" + binaryString;
            length++;
        }
        return binaryString;
    }

    public void decToBin1() {
        binResult1Snm = fillTo8Bits(snmokt1Int);
    }

    public void decToBin2() {
        binResult2Snm = fillTo8Bits(snmokt2Int);
    }

    public void decToBin3() {
        binResult3Snm = fillTo8Bits(snmokt3Int);
    }

    public void decToBin4() {
        binResult4Snm = fillTo8Bits(snmokt4Int);
    }

    public void showResult() {
        mainController.snmBinLabel.setText(binResult1Snm + "." + binResult2Snm + "." + binResult3Snm + "." + binResult4Snm);
    }
}