class Solution {
    merge(arr, l, m, h, output) {
        console.log(output);
        let left = l;
        let right = m + 1;
        const temp = [];

        while (left <= m && right <= h) {
            if (arr[left] <= arr[right]) {
                temp.push(arr[left]);
                left += 1;
            } else {
                temp.push(arr[right]);
                right += 1;
            }
        }

        while (left <= m) {
            temp.push(arr[left]);
            left += 1;
        }

        while (right <= h) {
            temp.push(arr[right]);
            right += 1;
        }
        console.log("temp", temp);
        for (let i = 0; i < temp.length; i++) {
            output[l + i] = temp[i];
        }
    }

    mergeSort(arr, l, h, output) {
        if (l >= h) {
            return;
        }

        const m = Math.floor((l + h) / 2);
        this.mergeSort(arr, l, m, output);
        this.mergeSort(arr, m + 1, h, output);
        this.merge(arr, l, m, h, output);
    }
}

const input = [3, 1, 2, 8, 2, 1, 5, 6, 3, 8, 7];
const output = new Array(input.length);
const solution = new Solution();
solution.mergeSort(input, 0, input.length - 1, output);
// console.log(output);  