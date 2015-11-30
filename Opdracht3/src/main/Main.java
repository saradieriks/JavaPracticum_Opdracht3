package main;

import java.awt.EventQueue;

import javax.swing.JFrame;

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
