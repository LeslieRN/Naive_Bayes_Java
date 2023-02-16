package com.example.data_mining;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class DataMiningApplication {

	public static void main(String[] args) throws Exception {
		//loading the data to data of zoo file with the datasource function
		DataSource dataSet = new DataSource("static/zoo.arff");
		Instances instances = dataSet.getDataSet();
		//setting the prediction attribute, in this case is the type of animal
		instances.setClassIndex(instances.numAttributes() - 1);
		Remove remove = new Remove();
		int[] ind = new int[]{};

		remove.setAttributeIndicesArray(ind);
		remove.setInputFormat(instances);
		// creamos un filtro para remover los atributos no necesarios (cadenas de texto) y tenemos el nuevo dataset
		Instances filter = Filter.useFilter(instances,remove);
		//Creating a Dense instance - setting the values one by one of the new instances that we want to use the model with
		Instance instance = new DenseInstance(18);
		//setting the attributes
		instance.setDataset(instances); // setting the data set for the new instance
		/*instance.setValue(0, "aardvark");
		instance.setValue(1, String.valueOf(true));
		instance.setValue(2, String.valueOf(false));
		instance.setValue(3, String.valueOf(false));
		instance.setValue(4, String.valueOf(false));
		instance.setValue(5, String.valueOf(false));
		instance.setValue(6, String.valueOf(true));
		instance.setValue(7, String.valueOf(true));
		instance.setValue(8, String.valueOf(true));
		instance.setValue(9, String.valueOf(true));
		instance.setValue(10, String.valueOf(true));
		instance.setValue(11, String.valueOf(false));
		instance.setValue(12, String.valueOf(false));
		instance.setValue(13, 4);
		instance.setValue(14, String.valueOf(true));
		instance.setValue(15, String.valueOf(false));
		instance.setValue(16, String.valueOf(false));
		instance.setValue(17, 3);*/

		instance.setValue(0, "bass");
		instance.setValue(1, String.valueOf(false));
		instance.setValue(2, String.valueOf(false));
		instance.setValue(3, String.valueOf(false));
		instance.setValue(4, String.valueOf(false));
		instance.setValue(5, String.valueOf(false));
		instance.setValue(6, String.valueOf(false));
		instance.setValue(7, String.valueOf(false));
		instance.setValue(8, String.valueOf(false));
		instance.setValue(9, String.valueOf(false));
		instance.setValue(10, String.valueOf(false));
		instance.setValue(11, String.valueOf(false));
		instance.setValue(12, String.valueOf(false));
		instance.setValue(13, 0);
		instance.setValue(14, String.valueOf(false));
		instance.setValue(15, String.valueOf(false));
		instance.setValue(16, String.valueOf(false));
		instance.setValue(17, 0);
		instance.setValue(14, String.valueOf(false));
		instance.setValue(15, String.valueOf(false));
		instance.setValue(16, String.valueOf(false));
		instance.setValue(17, 0);

		Instances test = filter;
		test.add(instance);
		NaiveBayes bayes = new NaiveBayes();
		//setting the classifier with the dataset instances
		bayes.buildClassifier(filter);

		//Creating evaluation object to test the classifier
		Evaluation eval = new Evaluation(test);
		eval.evaluateModel(bayes,test);
		Instance last = test.lastInstance();
		//real values and the prediction of evaluation of the model one time
		double prediction = eval.evaluateModelOnce(bayes,last);
		String animal = "";
		switch ((int) prediction) {
			case 0:
				animal = "Mammal";
				break;
			case 1:
				animal = "Bird";
				break;
			case 2:
				animal = "Reptile";
				break;
			case 3:
				animal = "Fish";
				break;
			case 4:
				animal = "Amphibian";
				break;
			case 5:
				animal = "Insect";
				break;
			case 6:
				animal = "Invertebrate";
				break;
			default:
				animal = "Unknown";
		}
		System.out.println("The animal:"+ instance.stringValue(0)+ " is predicted to be a: "+animal +" prediction = "+ prediction);

	}

}
