package com.kartik.org;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
/**
 * 
 * @author kmandal
 *
 */
public class JarDifference {

 static Map<String, Set<String>> mapOld = new HashMap<String, Set<String>>();

 static Map<String, Set<String>> mapNew = new HashMap<String, Set<String>>();

 /**
  * 
  * @param setA
  * @param setB
  * @return
  */
 public static Set<String> union(Set<String> setA, Set<String> setB) {

  Set<String> tmp = new TreeSet<String>(setA);

  tmp.addAll(setB);

  return tmp;

 }

 /**
  * 
  * @param setA
  * @param setB
  * @return
  */
 public static Set<String> intersection(Set<String> setA, Set<String> setB) {

  Set<String> tmp = new TreeSet<String>();

  for (String x : setA)

   if (setB.contains(x))

    tmp.add(x);

  return tmp;

 }

 /**
  * 
  * @param setA
  * @param setB
  * @return
  */
 public static Set<String> difference(Set<String> setA, Set<String> setB)

 {

  Set<String> tmp = new TreeSet<String>(setA);

  tmp.removeAll(setB);

  return tmp;

 }

 /**
  * 
  * @param setA
  * @param setB
  * @return
  */
 public static Set<String> symDifference(Set<String> setA, Set<String> setB) {

  Set<String> tmpA;

  Set<String> tmpB;

  tmpA = union(setA, setB);

  tmpB = intersection(setA, setB);

  return difference(tmpA, tmpB);

 }

 /**
  * 
  * @param jarFileList
  */
 public void getClassNamesFromJar(List<String> jarFileList) {

  int count = 0;

  for (String string : jarFileList) {

   count++;

   String jarFileName = string;

   System.out.println("Jar File Name: " + jarFileName);

   System.out.println("-- -- -- -- -- -- -- -- -- -- -- -- -- -");

   try {

    JarInputStream jarFile = new JarInputStream(

    new FileInputStream(jarFileName));

    JarEntry entry;

    Manifest m = jarFile.getManifest();

    Attributes atts = m.getMainAttributes();

    for (Map.Entry<Object, Object> entrys : atts.entrySet()) {

     System.out.println(entrys.getKey() + "-->>>> " +

     entrys.getValue());

    }

    while (true) {

     entry = jarFile.getNextJarEntry();

     if (entry == null) {

      break;

     }

     if ((entry.getName().endsWith(".class"))) {

      ClassNode classNode = new ClassNode();

      try {

       ClassReader classReader = new

       ClassReader(jarFile);

       classReader.accept(classNode, 0);

      } catch (Exception e3) {

       jarFile.close();

      }

      describeClass(classNode, count);

      //

      System.out.println(describeClass(classNode, count));

     }

    }

   } catch (Exception e) {

    System.out
      .println("Oops.. Encounter an issue while parsing jar"
        + e.toString());

   }

  }

 }

 /**
  * 
  * @param classNode
  * @param count
  * @return
  */
 public String describeClass(ClassNode classNode, int count) {

  StringBuilder classDescription = new StringBuilder();

  Type classType = Type.getObjectType(classNode.name);

  if ((classNode.access & Opcodes.ACC_PUBLIC) != 0) {

   classDescription.append("public ");

  }

  if ((classNode.access & Opcodes.ACC_PRIVATE) != 0) {

   classDescription.append("private ");

  }

  if ((classNode.access & Opcodes.ACC_PROTECTED) != 0) {

   classDescription.append("protected ");

  }

  if ((classNode.access & Opcodes.ACC_ABSTRACT) != 0) {

   classDescription.append("abstract ");

  }

  if ((classNode.access & Opcodes.ACC_INTERFACE) != 0) {

   classDescription.append("interface ");

  } else {

   classDescription.append("class ");

  }

  classDescription.append(classType.getClassName()).append("\n");

  classDescription.append("{\n");

  // The method signatures (e.g. -

  // "public static void main(String[]) throws Exception")

  @SuppressWarnings("unchecked")
  List<MethodNode> methodNodes = classNode.methods;

  Set<String> methodHold = new HashSet<String>();

  for (MethodNode methodNode : methodNodes) {

   String methodDescription = describeMethod(methodNode);

   methodHold.add(methodDescription);

   classDescription.append("\t").append(methodDescription)

   .append("\n");

  }

  if (count % 2 == 0) {

   mapOld.put(classType.getClassName(), methodHold);

  } else {

   mapNew.put(classType.getClassName(), methodHold);

  }

  classDescription.append("}\n");

  return classDescription.toString();

 }

 /**
  * 
  * @param methodNode
  * @return
  */
 public String describeMethod(MethodNode methodNode) {

  StringBuilder methodDescription = new StringBuilder();

  Type returnType = Type.getReturnType(methodNode.desc);

  Type[] argumentTypes = Type.getArgumentTypes(methodNode.desc);

  @SuppressWarnings("unchecked")
  List<String> thrownInternalClassNames = methodNode.exceptions;

  if ((methodNode.access & Opcodes.ACC_PUBLIC) != 0) {

   methodDescription.append("public ");

   // }

   /*
    * 
    * if ((methodNode.access & Opcodes.ACC_PRIVATE) != 0) {
    * 
    * methodDescription.append("private "); }
    * 
    * 
    * 
    * if ((methodNode.access & Opcodes.ACC_PROTECTED) != 0) {
    * 
    * methodDescription.append("protected "); }
    * 
    * 
    * 
    * if ((methodNode.access & Opcodes.ACC_STATIC) != 0) {
    * 
    * methodDescription.append("static "); }
    * 
    * 
    * 
    * if ((methodNode.access & Opcodes.ACC_ABSTRACT) != 0) {
    * 
    * methodDescription.append("abstract "); }
    * 
    * 
    * 
    * if ((methodNode.access & Opcodes.ACC_SYNCHRONIZED) != 0)
    * 
    * {
    * 
    * methodDescription.append("synchronized "); }
    */

   methodDescription.append(returnType.getClassName());

   methodDescription.append(" ");

   methodDescription.append(methodNode.name);

   methodDescription.append("(");

   for (int i = 0; i < argumentTypes.length; i++) {

    Type argumentType = argumentTypes[i];

    if (i > 0) {

     methodDescription.append(", ");

    }

    methodDescription.append(argumentType.getClassName());

   }

   methodDescription.append(")");

   /*
    * 
    * if (!thrownInternalClassNames.isEmpty()) {
    * 
    * methodDescription.append(" throws "); int i = 0; for
    * 
    * (String
    * 
    * thrownInternalClassName : thrownInternalClassNames) { if
    * 
    * (i > 0)
    * 
    * { methodDescription.append(", "); }
    * 
    * methodDescription.append(Type.
    * 
    * getObjectType(thrownInternalClassName).getClassName());
    * 
    * i++; } }
    */

  }

  return methodDescription.toString();

 }

 public static void main(String[] args) {

  JarDifference d = new JarDifference();

  List<String> jarFileName = new ArrayList<String>();

  jarFileName.add("D:\\Kartik\\jar_compare\\old\\httpclient-4.4.jar");

  jarFileName
    .add("D:\\Kartik\\jar_compare\\new\\httpclient-4.5.2.jar");

  d.getClassNamesFromJar(jarFileName);

  /*
   * 
   * boolean flag=false; StringBuilder classDescription = new
   * 
   * StringBuilder(); for (Map.Entry<String, Set<String>> entryOld :
   * 
   * mapOld.entrySet()) { for (Map.Entry<String, Set<String>>
   * 
   * entryNew :
   * 
   * mapNew.entrySet()) {
   * 
   * if(entryOld.getKey().equalsIgnoreCase(entryNew.getKey())){
   * 
   * flag=true;
   * 
   * } } if(!flag){
   * 
   * classDescription.append("Add new Class in latest Jar "
   * 
   * +entryOld.getKey()).append("\n");
   * 
   * classDescription.append("{\n");
   * 
   * //System.out.println("-- -- -- -- New-- -- -- -- -- -
   * 
   * "+entryOld.getKey()+
   * 
   * "-- -- -- -- -- -- -- -- -- -- "); Set<String>
   * val=entryOld.getValue();
   * 
   * for
   * 
   * (String string : val) {
   * 
   * classDescription.append("\t").append(string).append("\n");
   * 
   * //System.out.println(string); } classDescription.append("}\n");
   * 
   * }else{ flag=false; } }
   * 
   * System.out.println(classDescription.toString());
   */

  System.out.println();

  StringBuilder classDescriptionSecond = new StringBuilder();

  boolean falgVal = false;

  System.out
    .println("-#############################################################-");

  System.out
    .println("Remove Some Class in latest jar that list give below:");

  System.out
    .println("-#############################################################-");

  int i = 0;

  for (Map.Entry<String, Set<String>> entryNew : mapNew.entrySet())

  {

   for (Map.Entry<String, Set<String>> entryOld :

   mapOld.entrySet()) {

    if

    (entryOld.getKey().equalsIgnoreCase(entryNew.getKey())) {

     falgVal = true;

    }

   }

   if (!falgVal) {

    classDescriptionSecond.append(i + " " +

    entryNew.getKey())

    .append("\n");

    classDescriptionSecond.append("{\n");

    Set<String> val = entryNew.getValue();

    for (String string : val) {

     classDescriptionSecond.append("\t").append(string)

     .append("\n");

    }

    classDescriptionSecond.append("}\n");

    i++;

   } else {

    falgVal = false;

   }

  }

  System.out.println(classDescriptionSecond.toString());

  System.out.println();

  System.out
    .println("-#############################################################-");

  System.out
    .println("Matches Class in latest and old but some method have changes:");

  System.out

    .println("###############################################################-");

  StringBuilder classDescriptionThird = new StringBuilder();

  int j = 0;

  for (Map.Entry<String, Set<String>> entryNew : mapNew.entrySet())

  {

   for (Map.Entry<String, Set<String>> entryOld :

   mapOld.entrySet()) {

    if

    (entryOld.getKey().equalsIgnoreCase(entryNew.getKey())) {

     classDescriptionThird.append(j + " " +

     entryNew.getKey())

     .append("\n");

     classDescriptionThird.append("{\n");

     Set<String> valOld = entryOld.getValue();

     Set<String> valNew = entryNew.getValue();

     Set<String> temp = intersection(valOld,

     valNew);

     Set<String> addMethodInLatest =

     difference(valOld, temp);

     Set<String> removeMethodInLatest =

     difference(valNew, temp);

     for (String string : removeMethodInLatest) {

      classDescriptionThird

      .append("\t")

      .append("Update/remove old method in Latest Jar ->")

      .append(string).append("\n");

     }

     /*
      * 
      * this is need to display of how many new
      * 
      * method add for
      * 
      * (String string : addMethodInLatest) {
      * 
      * classDescriptionThird
      * 
      * .append("\t").append("Add new method in
      * 
      * Latest Jar -- >"
      * 
      * ).append(string).append("\n"); }
      */

     classDescriptionThird.append("}\n");

     j++;

    }

   }

  }

  System.out.println(classDescriptionThird.toString());

 }

}