# Grayscale-Image-Filters
A collection of basic filters to be applied on grayscale images

All files read a grayscale image `example.png`, and apply a filter to it.

## Task 1: Mean Filter
Reads the example image and applies a mean filter to it.
Included main method use 3x3 and 7x7 kernels, and output to `mean3x3.png` and `mean7x7.png` respectively.

## Task 2: Median Filter
Reads the example image and applies a median filter to it.
Included main method use 3x3 and 7x7 kernels, and output to `median3x3.png` and `median7x7.png` respectively.

## Task 3: Gaussian Filter
Reads the example image and applies a gaussian filter to it.
Included main method use 3x3 and 7x7 kernels, and output to `gaussian3x3.png` and `gaussian7x7.png` respectively.

***
## Observations
- Mean filter
  * The outputted image by the (7x7) kernel is blurrier than the one outputted by the (3x3) kernel.
- Median filter
  * The outputted image by the (7x7) kernel lost more detail than the one outputted by the (3x3) kernel.
- Gaussian filter
  * The outputted image by the (7x7) kernel is blurrier and darker than the one outputted by the (3x3) kernel.
- The median (3x3) filter outputted the best image as it removed the noise without blurring and without a huge loss of detail.

***
Done as a part of Introudction to Digital Media Engineering & Technology course.