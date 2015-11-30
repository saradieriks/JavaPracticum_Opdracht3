package main;

import java.awt.EventQueue;

import controller.WinkelController;

public class Main {

	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                WinkelController frame = new WinkelController();
            }
        });
    }
	
}
