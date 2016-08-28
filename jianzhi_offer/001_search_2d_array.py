# -*- coding:utf-8 -*-
class Solution:
    # array 二维列表
    def Find(self, array, target):
        # write code here
        i = 0
        nRow = len(array)
        nColumn = len(array[0])
        j = nColumn - 1
        while i < nRow and j >= 0:
            if array[i][j] > target:
                j = j - 1
            elif array[i][j] < target:
                i = i + 1
            else:
                return True
        return False
