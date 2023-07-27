(function () {
    const findKSumSubSequence = (index, output, sum) => {
        if (index >= input.length) {
            if (sum === sumK) {
                // console.log(output);
                return 1;
            }
            return 0;
        }
        // output.push(input[index]);
        sum += input[index];
        let left = findKSumSubSequence(index + 1, output, sum)
        // if (findKSumSubSequence(index + 1, output, sum) == true) {
        //     return true;
        // }
        // output.pop();
        sum -= input[index];
        let right = findKSumSubSequence(index + 1, output, sum)
        // if (findKSumSubSequence(index + 1, output, sum) == true) {
        //     return true;
        // }
        return (left + right);
    }
    var input = [1, 2, 1, 1];
    var sumK = 2;
    var output = [];
    const count = findKSumSubSequence(0, output, 0);
    console.log(count);
})();