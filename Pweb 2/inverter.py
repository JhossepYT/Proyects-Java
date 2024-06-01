def verifyI(word1, word2):
  if len(word1) != len(word2):
    print("Las palabras no tienen la misma longitud")
    return False
  for i in range(len(word1)):
    if word1[i] != word2[len(word2) - 1 - i]:
      return False
    return True
  
if verifyI("lool", "stop"):
  print("Si es su inverso")
else:
  print("No es su inverso")
