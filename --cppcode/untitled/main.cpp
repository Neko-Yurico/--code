#include <opencv2/opencv.hpp>
#include <stdio.h>
#include <stdlib.h>

using namespace cv;
using namespace std;

int main(int argc, char** argv)
{
    Mat Image_1 = imread("D://Image//5039.jpg");  //��ȡһ��ͼ��
    Mat Image_2 = imread("D://Image//5041.jpg"); //��ȡ��ͬ����һ��ͼ��

    namedWindow("ͼ1", WINDOW_AUTOSIZE);
    namedWindow("ͼ2", WINDOW_AUTOSIZE);

    imshow("ͼ1",Image_1);
    imshow("ͼ2",Image_2);

    int Image_1_cols = Image_1.cols;
    int Image_1_rows = Image_1.rows;

    int Image_2_cols = Image_2.cols;
    int Image_2_rows = Image_2.rows;

    cout << "Image_1_ cols:" << Image_1_cols <<" "<<"Image_2_ cols:"<< Image_2_cols << endl;
    cout << "Image_1_ rows:" << Image_1_rows <<" "<<"Image_2_ rows:"<< Image_2_rows <<endl;

    Mat dst;
    //dst = Image_1 + Image_2;     //���ַ�ʽ������ʵ��
    add(Image_1, Image_2, dst);

    namedWindow("���1", WINDOW_AUTOSIZE);
    imshow("���1", dst);
    waitKey();
    return 1;

}
