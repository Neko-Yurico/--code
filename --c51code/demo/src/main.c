/************************************************************************************

程序名称：1602显示屏测试程序   （晶振频率12MHz） 
功能说明: 通过1602显示屏显示字符            
程序版本：1.0 （2015/06）

************************************************************************************/


#include <stdio.h>
#include "stc15f2k60s2.h"        // 单片机STC15F2K60S2头文件,可以不再加入reg51.h
#include <intrins.h>                // 加入此头文件后,可使用_nop_库函数
#include "delay.h"                // 延时函数头文件
#include "1602.h"                  // 1602显示屏驱动程序头文件

sbit Data = P1 ^7;
sbit key1 = P2 ^3;
sbit key2 = P2 ^2;
sbit key3 = P2 ^1;
sbit key4 = P2 ^0;
sbit d1 = P5 ^2;
sbit d2 = P5 ^1;
sbit d3 = P5 ^0;

unsigned char rec_dat[16] = "   RH       C   ";
int limit = 30;

void io_init(void);

void DHT11_receive();

void main(void) {
    unsigned char i = 0;
    unsigned char flag = 1;
		char strTemp[20]; 
    io_init();
    d3 = 0;
    lcd_init();
    DelayMS(5);
    lcd_clear();
    DelayMS(5);
    lcd_write_string(0, 0, "hello EIE 194");
    DelayMS(1000);
    while (1) {
        if (key1 == 0) {
            DelayMS(30);
            if (key1 == 0) {
                d1 = 0;
                d2 = 1;
                d3 = 1;
                lcd_clear();
                DelayMS(5);
                lcd_write_string(0, 0, "MOD1         ");
                if (flag == 1) {
                    flag = 0;
                } else {
                    flag = 1;
                }
                while (key1 == 0);
                DelayMS(200);
            }
        }
        if (key2 == 0) {
            DelayMS(30);
            if (key2 == 0) {
                d1 = 1;
                d2 = 0;
                d3 = 1;
                lcd_clear();
                DelayMS(5);
                lcd_write_string(0, 0, "MOD2         ");
                while (key2 == 0);
                DelayMS(200);
                DHT11_receive();
                lcd_clear();
                DelayMS(5);
                lcd_write_string(0, 0, "COMMAND Mod");
                lcd_write_string(0, 1, "Use K4 To UPDATE");
            }
        }
        if (key3 == 0) {
            DelayMS(30);
            if (key3 == 0) {
                d1 = 1;
                d2 = 1;
                d3 = 0;
                lcd_clear();
                DelayMS(5);
                lcd_write_string(0, 0, "MOD3         ");
                while (key3 == 0);
                DelayMS(200);
                d3 = 1;
                DHT11_receive();
                lcd_clear();
                DelayMS(5);
                lcd_write_string(0, 0, "SET upper limit");
                lcd_write_string(0, 1, "USE K4 to SET");
            }
        }
				if (d1 == 0) {
						DHT11_receive();
						lcd_clear();
						DelayMS(5);
						lcd_write_string(0, 0, "Auto detecting");
						lcd_write_string(0, 1, rec_dat);
						DelayMS(200);
				}
				if (d2 == 0) {
						if (key4 == 0) {
								DelayMS(30);
								if (key4 == 0) {
										DHT11_receive();
										lcd_clear();
										DelayMS(5);
										lcd_write_string(0, 0, "COMMAND Mod");
										lcd_write_string(0, 1, rec_dat);
										while (key4 == 0);
										DelayMS(100);
								}
						}
				}
				if (d1 == 1 && d2 == 1 && d3 == 1) {
						if (key4 == 0) {
								DelayMS(30);
								if (key4 == 0) {
										while (key4 == 0);
										DelayMS(100);
								}
								while (key4 != 0) {
										DHT11_receive();
										lcd_clear();
										DelayMS(5);
										lcd_write_string(0, 0, "k1=up k2=down");
										sprintf(strTemp, "%d", limit); 
										lcd_write_string(0, 1, "    K4 to exit");
										lcd_write_string(0, 1, strTemp);
										if (key1 == 0) {
												DelayMS(30);
												if (key1 == 0) {
														limit ++;
														while (key1 == 0);
												}
										}
										if (key2 == 0) {
												DelayMS(30);
												if (key2 == 0) {
														limit --;
														while (key2 == 0);
												}
										}
								}
								d3=0;
                DHT11_receive();
                lcd_clear();
                DelayMS(5);
                lcd_write_string(0, 0, "SET Finish");
                lcd_write_string(0, 1, "USE K1/K2 to Exit");
						}
				}
		}
}


//将IO口设定为普通模式
void io_init(void) {

    P0M0 = 0X00;
    P0M1 = 0X00;
    P1M0 = 0X00;
    P1M1 = 0X00;
    P2M0 = 0X00;
    P2M1 = 0X00;
    //P3M0=0X00;
    //P3M1=0X00;
    P4M0 = 0X00;
    P4M1 = 0X00;
    P5M0 = 0X00;
    P5M1 = 0X00;
    DelayMS(5);
}


void DHT11_start() {
    Data = 1;
    Delay2US(1);
    Data = 0;
    DelayMS(20);
    Data = 1;
    Delay2US(10);
}

unsigned char DHT11_rec_byte() {
    unsigned char i, dat = 0;
    for (i = 0; i < 8; i ++) {
        dat <<= 1;
        while (Data == 0);
        Delay2US(20);
        if (Data == 1) {
            dat += 1;
            while (Data);
        }
    }
    return dat;
}

void DHT11_receive() {
    unsigned char RH, RL, TH, TL, revise;

    DHT11_start();

    if (Data == 0) {

        while (Data == 0);

        while (Data == 1);
        RH = DHT11_rec_byte();
        RL = DHT11_rec_byte();
        TH = DHT11_rec_byte();
        TL = DHT11_rec_byte();
        revise = DHT11_rec_byte();

        Delay2US(12);

        if ((RH + RL + TH + TL) == revise) {

            rec_dat[0] = '0' + (RH / 10);;
            rec_dat[1] = '0' + (RH % 10);
						rec_dat[2] =' ';
						rec_dat[3] = 'R' ;
						rec_dat[4] = 'H';
						rec_dat[5]=' ';
						rec_dat[6]=' ';
						rec_dat[7]=' ';
						rec_dat[8]=' ';
            rec_dat[9] = '0' + (TH / 10);
            rec_dat[10] = '0' + (TH % 10);
						rec_dat[11] ='0'+TL;
						rec_dat[12] = 'C';
						rec_dat[13] = ' ' ;
						rec_dat[14]=' ';
        }
    }
}






