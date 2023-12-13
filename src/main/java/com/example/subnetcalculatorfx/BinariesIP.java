package com.example.subnetcalculatorfx;

public class BinariesIP {
    String[] ipSplit;
    int okt1Int;
    int okt2Int;
    int okt3Int;
    int okt4Int;
    boolean validated = false;
    String binResult1;
    String binResult2;
    String binResult3;
    String binResult4;



    private MainController mainController;
    BinariesSNM binariesSNM;
    Calculation calculation;

    public BinariesIP(MainController mainController) {
        this.mainController = mainController;
    }

    public void stringToIntIp(String ipAddress) {
        boolean validInput = false;
        while (!validInput) {
            ipSplit = ipAddress.split("\\.");

            try {
                String okt1 = ipSplit[0];
                String okt2 = ipSplit[1];
                String okt3 = ipSplit[2];
                String okt4 = ipSplit[3];

                okt1Int = Integer.parseInt(okt1);
                System.out.println("okt1Int: " + okt1Int);
                okt2Int = Integer.parseInt(okt2);
                okt3Int = Integer.parseInt(okt3);
                okt4Int = Integer.parseInt(okt4);

                validInput = true;
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                validated = false;
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
        binResult1 = fillTo8Bits(okt1Int);
    }

    public void decToBin2() {
        binResult2 = fillTo8Bits(okt2Int);
    }

    public void decToBin3() {
        binResult3 = fillTo8Bits(okt3Int);
    }

    public void decToBin4() {
        binResult4 = fillTo8Bits(okt4Int);
    }

    public void showResult() {
       mainController.ipBinLabel.setText(binResult1 + "." + binResult2 + "." + binResult3 + "." + binResult4);
    }
}