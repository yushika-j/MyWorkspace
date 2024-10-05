import nltk
from nltk.corpus import words
from collections import Counter

# Frequency analysis for English letters (most frequent first)
english_letter_frequency = 'ETAOINSHRDLCUMWFGYPBVKJXQZ'

# Load the English word corpus
english_words = set(words.words())

# Ciphertext (replace with your actual ciphertext)
ciphertext = """KZRNK GJKIP ZBOOB XLCRG BXFAU GJBNG RIXRU XAFGJ BXRME 
MNKNG BURIX KJRXR SBUER ISATB UIBNN RTBUM NBIGK EBIGR 
OCUBR GLUBN JBGRL SJGLN GJBOR ISLRS BAFFO AZBUN RFAUS 
AGGBI NGLXM IAZRX RMNVL GEANG CJRUE KISRM BOOAZ GLOKW 
FAUKI NGRIC BEBRI NJAWB OBNNO ATBZJ KOBRC JKIRR NGBUE 
BRINK XKBAF QBROA LNMRG MALUF BBG"""

# Step 1: Count frequency of letters in the ciphertext
def count_letter_frequency(text):
    filtered_text = ''.join(filter(str.isalpha, text)).upper()
    return Counter(filtered_text)

# Step 2: Generate initial substitution based on frequency
def initial_substitution(cipher_freq, english_freq):
    cipher_letters = [item[0] for item in cipher_freq.most_common()]
    initial_map = {cipher_letter: english_letter for cipher_letter, english_letter in zip(cipher_letters, english_freq)}
    return initial_map

# Step 3: Decrypt the text using the substitution map
def decrypt_with_substitution(text, substitution_map):
    decrypted_text = []
    for char in text:
        if char.upper() in substitution_map:
            new_char = substitution_map[char.upper()]
            if char.islower():
                decrypted_text.append(new_char.lower())
            else:
                decrypted_text.append(new_char)
        else:
            decrypted_text.append(char)
    return ''.join(decrypted_text)

# Step 4: Check decrypted text against English dictionary
def check_valid_words(decrypted_text):
    words_list = decrypted_text.split()
    invalid_words = []
    for word in words_list:
        if word.lower().strip(",.!?") not in english_words:
            invalid_words.append(word)
    return invalid_words

# Step 5: Manual substitution refinement (optional)
def refine_substitution(substitution_map, old_char, new_char):
    reverse_map = {v: k for k, v in substitution_map.items()}
    if old_char in reverse_map:
        cipher_char = reverse_map[old_char]
        substitution_map[cipher_char] = new_char
    return substitution_map

# Main decryption process
cipher_freq = count_letter_frequency(ciphertext)
substitution_map = initial_substitution(cipher_freq, english_letter_frequency)
decrypted_text = decrypt_with_substitution(ciphertext, substitution_map)

print("Initial Decrypted Text:")
print(decrypted_text)

# Step 6: Identify invalid words
invalid_words = check_valid_words(decrypted_text)
print("\nInvalid words detected:")
print(invalid_words)

# Step 7: Refine the substitution map (manual refinement example)
substitution_map = refine_substitution(substitution_map, 'K', 'H')  # Example substitution
decrypted_text = decrypt_with_substitution(ciphertext, substitution_map)

print("\nRefined Decrypted Text:")
print(decrypted_text)

# Re-check for invalid words
invalid_words = check_valid_words(decrypted_text)
print("\nInvalid words after refinement:")
print(invalid_words)
