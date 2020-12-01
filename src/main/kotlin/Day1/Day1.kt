package Day1

fun solvePuzzle1(inputValues: List<String>): Int {
    var i = 0;
    var k = 0;

    while (i < inputValues.size) {
        while (k < inputValues.size) {
            if (inputValues[i].toInt() + inputValues[k].toInt() == 2020)
                return inputValues[i].toInt() * inputValues[k].toInt()
            else {
                k++;
            }
        }
        i ++;
        k = 0;
    }

    return -1;
}

fun solvePuzzle2(inputValues: List<String>): Int {
    var i = 0;
    var j = 0;
    var k = 0;

    while (i < inputValues.size) {
        while(j < inputValues.size) {
            while (k < inputValues.size) {
                if (inputValues[i].toInt() + inputValues[j].toInt() + inputValues[k].toInt() == 2020)
                    return inputValues[i].toInt() * inputValues[j].toInt() * inputValues[k].toInt()
                else {
                    k++
                }
            }
            j++
            k = 0
        }
        i++;
        j = 0;
        k = 0;
    }

    return -1;
}