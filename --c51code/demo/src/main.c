/************************************************************************************

程序名称：1602显示屏测试程序   （晶振频率12MHz） 
功能说明: 通过1602显示屏显示字符            
程序版本：1.0 （2015/06）

************************************************************************************/


#include <stdio.h>
#include "stc15f2k60s2.h"        					// 单片机STC15F2K60S2头文件,可以不再加入reg51.h
#include <intrins.h>                			// 加入此头文件后,可使用_nop_库函数
#include "delay.h"                				// 延时函数头文件
#include "1602.h"                  				// 1602显示屏驱动程序头文件
#include "uart.h"

sbit Data = P1 ^7;
sbit key1 = P2 ^3;
sbit key2 = P2 ^2;
sbit key3 = P2 ^1;
sbit key4 = P2 ^0;
sbit d1 = P5 ^2;
sbit d2 = P5 ^1;
sbit d3 = P5 ^0;

int limit = 35;																		//温度上限
unsigned char rec_dat[13] = "   RH       C";
unsigned char RH, RL, TH, TL, revise;
unsigned char warnFlag = 0;												//是否报警
unsigned char kickFlag = 0;												//是否取消报警
char i;

void io_init(void);
void UartInit(void);
void DHT11_receive();

void main(void) {
    //unsigned char i = 0;
    unsigned char flag = 1;
		char strTemp[20]; 
    io_init();
    d3 = 0;
    lcd_init();																		//LCD初始化
    DelayMS(5);
    lcd_clear();																	//清屏函数
    DelayMS(5);
    lcd_write_string(0, 0, "hello EIE 194");
    //DelayMS(1000);
		TMOD = 0x01;
		TH0 = 0xD8;
		TL0 = 0xf0;
	  EA = 1;
	  ET0 = 1;
		TR0 = 1;
	  i = 0;
    while (1) {
			  if(i = 100){
					i = 0;
					DHT11_receive();	
				}
        if (key1 == 0) {													//进入模式1
            DelayMS(30);
            if (key1 == 0) {
                d1 = 0;
                d2 = 1;
                d3 = 1;
                lcd_clear();
                DelayMS(5);
                lcd_write_string(0, 0, "MOD1         ");
							  lcd_write_string(0, 1, "The default mode");
                while (key1 == 0);
                DelayMS(200);
								kickFlag = 0;
								warnFlag = 0;
            }
        }
        if (key2 == 0) {													//进入模式2
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
								kickFlag = 0;
								warnFlag = 0;
            }
        }
        if (key3 == 0 && warnFlag == 0) {					//进入模式3——设定温度上限1
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
                lcd_clear();
                DelayMS(5);
                lcd_write_string(0, 0, "SET upper limit");
                lcd_write_string(0, 1, "USE K4 to SET");
            }
        }
				if (d1 == 0) {						     						//当蓝灯亮时，显示温度和湿度，并发送给上位机
						//DHT11_receive();	
						lcd_clear();
						DelayMS(5);
						lcd_write_string(0, 0, "Auto detecting");
						lcd_write_string(0, 1, rec_dat);
						UartInit();
					  SendString(rec_dat);
						DelayMS(1000);
				}
				if (d2 == 0) {														//当绿灯亮时，按下k4可显示温度和湿度，并发送给上位机
					//DHT11_receive();
					lcd_clear();
					DelayMS(5);
					lcd_write_string(0, 0, "COMMAND Mod");
					lcd_write_string(0, 1, rec_dat);
					if (key4 == 0) {
								DelayMS(30);
								if (key4 == 0) {					
										lcd_clear();
										DelayMS(5);
										lcd_write_string(0, 0, "Has been sent");
										lcd_write_string(0, 1, rec_dat);
										UartInit();
										SendString(rec_dat);
										DelayMS(1000);
										while (key4 == 0);
										DelayMS(100);
								}
						}/*else{
							  DHT11_receive();
                lcd_clear();
                DelayMS(5);
                lcd_write_string(0, 0, "COMMAND Mod");
                lcd_write_string(0, 1, "Use K4 To UPDATE");
						}*/
							
						DelayMS(200);
				}
				if (d1 == 1 && d2 == 1 && d3 == 1 && warnFlag == 0) {      //设定温度上限2
						if (key4 == 0) {
								DelayMS(30);
								if (key4 == 0) {
										while (key4 == 0); 
										DelayMS(100);
									  lcd_clear();
								}
								while (key4 != 0) {
										//DHT11_receive();
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
								kickFlag = 0;
								warnFlag = 0;
						}
				}
				while(TH >= limit && kickFlag == 0){
					d1 = 1;
					d2 = 1;
					d3 = ~d3;
					warnFlag = 1;
					//DHT11_receive();
					lcd_clear();
					DelayMS(5);
					lcd_write_string(0, 0, "TEMP OVERRUN!"); 
					lcd_write_string(0, 1, "KICK K4 TO CLOSE");
					DelayMS(200);
					if(key4 == 0){
						DelayMS(30);
						if(key4==0){
							d3 = 1;
							kickFlag = 1;
							warnFlag = 0;
							//DHT11_receive();
							lcd_clear();
							DelayMS(5);
							lcd_write_string(0, 0, "ALARM turned off");
							DelayMS(1500);
							lcd_write_string(0, 0, "hello EIE 194   ");
						}
					}
				} 
     }
/*				if(TH >= limit && flag == 1){
					if (key4 != 0) {
						DelayMS(30);
						if (key4 != 0) {
							warning();
							DelayMS(200);
					  }
					}
					if (key4 == 0) {	
						DelayMS(30);
						if (key4 == 0) {
							flag=0;
							d3 = 1;
							DHT11_receive();
              lcd_clear();
              DelayMS(5);
							lcd_write_string(0, 0, "ALARM turned off");
							DelayMS(100);
					  }
					}
			  }
				if(TH<limit){
					flag = 1;
				}
		}
}*/
}

void time0_int(void) interrupt 1{
	TH0 = 0xD8;
	TL0 = 0xf0;
	i++;
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

unsigned char DHT11_rec_byte() {      					   //DHT11获取数据
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

void DHT11_receive() {                             //获取DHT11上的湿度和温度
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
						rec_dat[8]='0' + (TH / 10);
            rec_dat[9] = '0' + (TH % 10);
            rec_dat[10] = '.';
						rec_dat[11] ='0'+TL;
						rec_dat[12] = 'C';
						rec_dat[13] = ' ' ;
						rec_dat[14]=' ';
        }
    }
}






