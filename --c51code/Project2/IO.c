#include <reg51.h>
sbit P1_0=P1^0;
void main()
{
    TMOD=0x02;
    TH0=0x06;TL0=0x06;
    EA=1;ET0=1;
    TR0=1;
    while(1);
}
void time0_int(void) interrupt 1
{
    P1_0=!P1_0;
}