package com.volkov.main;

import com.volkov.model.CiPlusPlusLang;
import com.volkov.model.JavaLangCoding;
import com.volkov.model.Program;

public class Main {
    public static void main(String[] args) {
        Program javaCode = new JavaLangCoding();
        javaCode.startProgram();
        Program ciPlusPlus = new CiPlusPlusLang();
        ciPlusPlus.startProgram();
    }
}
