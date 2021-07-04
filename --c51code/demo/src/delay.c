/************************************************************************************

程序名称：延时函数(晶振频率12MHz)
功能说明: 延时毫秒与微秒
程序版本：1.0 （2014/06）

************************************************************************************/

#include "stc15f2k60s2.h"	    // 单片机STC15F2K60S2头文件,可以不再加入reg51.h
#include <intrins.h>			    // 加入此头文件后,可使用_nop_库函数
#include <stdio.h>


void Delay1us()		//@11.0592MHz
{
	_nop_();

}



void Delay1ms()		//@11.0592MHz
{
	unsigned char i, j;

	i = 11;
	j = 192;
	do
	{
		while (--j);
	} while (--i);
}

void DelayMS(int t)
{
	while(t--)
	{
		Delay1ms();
	}
}

void Delay2US(int t)
{	

	while(t--)
	{
		_nop_();
		_nop_();
		_nop_();
		_nop_();
	}
}



