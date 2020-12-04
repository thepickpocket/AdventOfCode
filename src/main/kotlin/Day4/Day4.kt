package Day4

fun solvePuzzle1(passportInputs: List<String>): Int {
    val validFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
    var validFieldCount = 0
    var validPassportCount = 0
    var passportsChecked = 0

    var passports = createPassportInputs(passportInputs)
    println(passports)

    passports.forEach { passport ->
        val fieldMap = passport.split(" ").associate {
            val (key, value) = it.split(":")
            key to value
        }

        validFields.forEach{field ->
            if (fieldMap.containsKey(field))
                validFieldCount++
        }

        if (validFieldCount == 7) {
            validPassportCount++
        }

        validFieldCount = 0
    }

    println("Passports Checked: $passportsChecked")
    return validPassportCount
}

fun solvePuzzle2(passportInputs: List<String>): Int {
    val validEyeColor = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
    var validFieldCount = 0
    var validPassportCount = 0
    var passportsChecked = 0

    var passports = createPassportInputs(passportInputs)
    println(passports)

    passports.forEach { passport ->
        val fieldMap = passport.split(" ").associate {
            val (key, value) = it.split(":")
            key to value
        }

        fieldMap.forEach{field ->
            when (field.key) {
                "byr" -> {
                    if (field.value.length == 4 && field.value.chars().allMatch(Character::isDigit) && (field.value.toInt() in 1920..2002))
                        validFieldCount++
                }
                "iyr" -> {
                    if (field.value.length == 4 && field.value.chars().allMatch(Character::isDigit) && (field.value.toInt() in 2010..2020))
                        validFieldCount++
                }
                "eyr" -> {
                    if (field.value.length == 4 && field.value.chars().allMatch(Character::isDigit) && (field.value.toInt() in 2020..2030))
                        validFieldCount++
                }
                "hgt" -> {
                    if (field.value.contains("cm") && (field.value.subSequence(0, field.value.indexOf("cm")).toString().toInt() in 150..193))
                        validFieldCount++
                    else if (field.value.contains("in") && (field.value.subSequence(0, field.value.indexOf("in")).toString().toInt() in 59..76))
                        validFieldCount++
                }
                "hcl" -> {
                    if (field.value.length == 7 && field.value[0] == '#' && field.value.substring(1).chars().anyMatch(Character::isLetterOrDigit))
                        validFieldCount++
                }
                "ecl" -> {
                    if (validEyeColor.contains(field.value))
                        validFieldCount++
                }
                "pid" -> {
                    if (field.value.length == 9 && field.value.chars().allMatch(Character::isDigit))
                        validFieldCount++
                }
            }
        }

        if (validFieldCount == 7) {
            validPassportCount++
        }

        validFieldCount = 0
    }

    println("Passports Checked: $passportsChecked")
    return validPassportCount
}

fun createPassportInputs(inputLines: List<String>) : List<String> {
    var passportLines = mutableListOf<String>()

    var passportLine = ""
    inputLines.forEach { line ->
        if (!line.isNullOrEmpty()) {
            if (passportLine.isEmpty())
                passportLine += line
            else
                passportLine += " $line"
        } else {
            passportLines.add(passportLine)
            passportLine = ""
        }
    }

    return passportLines
}