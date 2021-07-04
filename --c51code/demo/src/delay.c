/************************************************************************************

�������ƣ���ʱ����(����Ƶ��12MHz)
����˵��: ��ʱ������΢��
����汾��1.0 ��2014/06��

************************************************************************************/

#include "stc15f2k60s2.h"	    // ��Ƭ��STC15F2K60S2ͷ�ļ�,���Բ��ټ���reg51.h
#include <intrins.h>			    // �����ͷ�ļ���,��ʹ��_nop_�⺯��
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



