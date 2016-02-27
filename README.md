# MaskFormatter-For-JavaFX
Máscara para JavaFX. Biblioteca criada para a implementação de máscaras para componentes do JavaFX, totalmente funcionou e fácil de implementar em qualquer Classe, sem necessidade de alterar o FXML.
## Observações:
 * Ainda está em fase de implementação.
 * por enquanto so suportar o componente TextField.


Declaração:
--------
```
MaskFormatter formatter = new MaskFormatter(textfield);
formatter.setMask(int maskType);
```
###Tipos de Mascaras(MaskType):
- MaskFormatter.TEL_8DIG: Máscara de telefone com 8 digitos. Ex: (61) 7070-7070.
- MaskFormatter.TEL_9DIG: Máscara de telefone com 9 digitos. Ex: (61) 97070-7070.
- MaskFormatter.CPF: Máscara de CPF. Ex: 000.000.000-00.
- MaskFormatter.RG: Máscara de RG. Ex: 00.000.000-0

##Como usar:
--------
```
MaskFormatter formatter = new MaskFormatter(textfield);
formatter.setMask(MaskFormatter.TEL_8DIG);

MaskFormatter formatter = new MaskFormatter(textfield);
formatter.setMask(MaskFormatter.CPF);
```
###Download da biblioteca:
Baixe o JAR e coloque no seu projeto: [MaskJavaFX](https://www.dropbox.com/s/nuaw3qfn9rxdgtj/MaskFormatterFX.jar?dl=0)
