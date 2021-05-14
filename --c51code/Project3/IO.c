#include <reg51.h>
#include <intrins.h>
void main()
{
	unsigned char i;
	unsigned int j;
	SCON=0x00;
	i=0xFE;
	for (; ;)
	{
		SBUF=i;
		while (!TI) { ;}
		TI=0;
		for (j=0;j<=20000;j++) {_nop_();}
		i=_crol_(i,1);
	}
}