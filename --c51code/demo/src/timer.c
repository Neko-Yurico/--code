#include "stc15f2k60s2.h"	    // 单片机STC15F2K60S2头文件,可以不再加入reg51.h
#include <intrins.h>			    // 加入此头文件后,可使用_nop_库函数
#include <stdio.h>
char time0 = 0;
void Timing_init(){
	TMOD = 0x01;
	TH0 = 0xB8;
	TL0 = 0x00;
	TR0 = 1;
	ET0 = 1;
	TR0 = 1;
	/*for(;time0 == 4000;){
		while(!TF0);
		time0++;
	}*/
}
void et0() interrupt 1{
	TH0 = 0xB8;
	TL0 = 0x00;
	time0++;
}