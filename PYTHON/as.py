def generate_cipher_key(shift):
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    shifted_alphabet = alphabet[shift:] + alphabet[:shift]
    key = dict(zip(alphabet, shifted_alphabet))
    return key
def encrypt(message, key):
    encrypted_message = ''
    for char in message:
        if char.isalpha():
            if char.islower():
                encrypted_message += key[char]
            else:
                encrypted_message += key[char.lower()].upper()
        else:
            encrypted_message += char
    return encrypted_message
def decrypt(ciphertext, key):
    reverse_key = {v: k for k, v in key.items()}
    decrypted_message = ''
    for char in ciphertext:
        if char.isalpha():
            if char.islower():
                decrypted_message += reverse_key[char]
            else:
                decrypted_message += reverse_key[char.lower()].upper()
        else:
            decrypted_message += char
    return decrypted_message
def main():
    shift = int(input("Enter the shift value for the cipher: "))
    key = generate_cipher_key(shift)

    choice = input("Encrypt or decrypt? (e/d): ").lower()
    if choice == 'e':
        plaintext = input("Enter the message to encrypt: ")
        encrypted = encrypt(plaintext, key)
        print("Encrypted message:", encrypted)
    elif choice == 'd':
        ciphertext = input("Enter the message to decrypt: ")
        decrypted = decrypt(ciphertext, key)
        print("Decrypted message:", decrypted)
    else:
        print("Invalid choice. Please enter 'e' for encrypt or 'd' for decrypt.")

if __name__ == "__main__":
    main()