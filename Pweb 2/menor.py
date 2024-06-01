def cadena_menor(lista, n):
  indices = []
  for i in range(len(lista)):
    sub_indices = []
    for j in range(len(lista[i])):
      if len(lista[i][j]) < n:
        sub_indices.append(j)
    indices.append(sub_indices)
  return indices

list = [["apple", "banana", "cherry"], ["cat", "dog"], ["orange", "kiwi", "mango"]]
print(cadena_menor(list, 6))