package com.junitTest;

public class Calculator extends Thread{

    /**
     * �ӷ�
     * @param arg1
     * @param arg2
     * @return
     */
    public int add(int arg1, int arg2) {
        return arg1 + arg2;
    }
    
    /**
     * ����
     * @param arg1
     * @param arg2
     * @return
     */
    public int sub(int arg1, int arg2) {
        return arg1 - arg2;
    }
    
    /**
     * �˷�
     * @param arg1
     * @param arg2
     * @return
     */
    public int mul(int arg1, int arg2) {
        return arg1 * arg2;
    }
    
    /**
     * ����
     * @param arg1
     * @param arg2
     * @return
     */
    public int div(int arg1, int arg2) {
        return arg1 / arg2;
    }
    
    public void timeOut(){
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


