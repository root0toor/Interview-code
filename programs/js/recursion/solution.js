(function () {
    const findKSumSubSequence = (index, output, sum) => {
        if (index >= input.length) {
            if(sum === sumK) {
                console.log(output);
            }
            return;
        }
        output.push(input[index]);
        sum += input[index];
        findKSumSubSequence(index + 1, output, sum);
        output.pop();
        sum -= input[index];
        findKSumSubSequence(index + 1, output, sum);
    }
    var input = [1, 2, 1];
    var sumK = 2;
    var output = [];
    findKSumSubSequence(0, output, 0);
})();