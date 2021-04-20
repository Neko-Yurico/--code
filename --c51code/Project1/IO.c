#include<intrins.h>
#include<reg52.h>
#define uchar unsigned  char
#define uint unsigned  int

void  mDelay(uint Delay)
{
    uint i;
    for (; Delay > 0; Delay--) {
        for (i = 0; i < 110; i++) {
        }
    }
}

void  main(void)
{
    unsigned  char a,i;
    while (1)
    {
        a=0x01;
        for (i = 0; i < 8; i++) {
            a=_crol_(a,1);
            P2=a;
            mDelay(500) ;
        }
    }
}