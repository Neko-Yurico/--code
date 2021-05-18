#include <opencv2/opencv.hpp>
#include <stdio.h>
#include <stdlib.h>

using namespace cv;
using namespace std;

int main(int argc, char** argv)
{
    Mat Image_1 = imread("D://Image//5039.jpg");  //读取一幅图像
    Mat Image_2 = imread("D://Image//5041.jpg"); //读取相同的另一幅图像

    namedWindow("图1", WINDOW_AUTOSIZE);
    namedWindow("图2", WINDOW_AUTOSIZE);

    imshow("图1",Image_1);
    imshow("图2",Image_2);

    int Image_1_cols = Image_1.cols;
    int Image_1_rows = Image_1.rows;

    int Image_2_cols = Image_2.cols;
    int Image_2_rows = Image_2.rows;

    cout << "Image_1_ cols:" << Image_1_cols <<" "<<"Image_2_ cols:"<< Image_2_cols << endl;
    cout << "Image_1_ rows:" << Image_1_rows <<" "<<"Image_2_ rows:"<< Image_2_rows <<endl;

    Mat dst;
    //dst = Image_1 + Image_2;     //两种方式都可以实现
    add(Image_1, Image_2, dst);

    namedWindow("求和1", WINDOW_AUTOSIZE);
    imshow("求和1", dst);
    waitKey();
    return 1;

}
