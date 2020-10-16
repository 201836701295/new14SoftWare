//
// File: computepsd.h
//
// MATLAB Coder version            : 5.0
// C/C++ source code generated on  : 15-Oct-2020 21:35:42
//
#ifndef COMPUTEPSD_H
#define COMPUTEPSD_H

// Include Files
#include <cstddef>
#include <cstdlib>
#include "rtwtypes.h"
#include "dspmath_types.h"

// Function Declarations
extern void computepsd(const coder::array<float, 2U> &Sxx1, const coder::array<
        double, 2U> &w2, const char range[8], double nfft, double Fs, coder::array<
        float, 2U> &varargout_1, coder::array<double, 1U> &varargout_2, char
                       varargout_3_data[], int varargout_3_size[2]);

#endif

//
// File trailer for computepsd.h
//
// [EOF]
//
