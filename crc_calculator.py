class xor_cal():
    def xor(word1, word2):
        result = []
        for i in range(1, len(word2)):
            if word1[i] == word2[i]:
                result.append('0')
            else:
                 result.append('1')
        return ''.join(result)


class crc_cal():
    def convert_to_binary(word):
        return ' '.join(format(x, 'b') for x in bytearray(word, 'utf-8'))


    def modulo_cal(val,key):
        p = len(key)
        tmp = val[0: p]

        while p < len(val):

            if tmp[0] == '1':
                tmp = xor_cal.xor(val, tmp) + val[p]
            else:
                tmp = xor_cal.xor('0' * p, tmp) + val[p]
            p += 1

        if tmp[0] == '1':
            tmp = xor_cal.xor(val, tmp)
        else:
            tmp = xor_cal.xor('0' * p, tmp)

        checkword = tmp
        return checkword




class enc_dec():
    def enc(val, key):
        l_key = len(key)
        new_data = val + '0' * (l_key - 1)
        rem = crc_cal.modulo_cal(new_data, key)
        codeword = val + rem
        return codeword

    def decode( data, key):
        l_key = len(key)

        appended_data = data + '0' * (l_key - 1)
        remainder = crc_cal.modulo_cal(appended_data, key)

        return remainder

